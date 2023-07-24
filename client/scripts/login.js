const poolData = {
    UserPoolId: 'eu-west-1_BZAu5yKxc',
    ClientId: 'l9lu2cspu2ago5vmv9b05l3ub',
};

const userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);
    function loginUser(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const authenticationData = {
        Username: username,
        Password: password,
    };
    console.log(authenticationData)
    const authenticationDetails = new AmazonCognitoIdentity.AuthenticationDetails(authenticationData);
    const userData = {
        Username: username,
        Pool: userPool,
    };

    const cognitoUser = new AmazonCognitoIdentity.CognitoUser(userData);

    cognitoUser.authenticateUser(authenticationDetails, {
        onSuccess: function (session) {
        console.log('User logged in successfully. Access Token:', session.getAccessToken().getJwtToken());
        // You can redirect the user to a dashboard or another page upon successful login.
        localStorage.setItem('jwt',session.getAccessToken().getJwtToken() )
        },
        onFailure: function (err) {
        console.error('Error logging in:', err.message || JSON.stringify(err));
        // Handle login failure, e.g., display an error message on the login form.
        },
    });
}