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
        localStorage.setItem('jwt',session.getAccessToken().getJwtToken())
        },
        onFailure: function (err) {
        console.error('Error logging in:', err.message || JSON.stringify(err));
        },
    });
}

function authorizeUser(event){
    event.preventDefault();
    const username = document.getElementById('username').value;
    const authCode = document.getElementById('auth-code').value;

    const userData = {
        Username: username,
        Pool: userPool,
    };
      
    const cognitoUser = new AmazonCognitoIdentity.CognitoUser(userData);
    cognitoUser.confirmRegistration(authCode, true, (err, result) => {
        if (err) {
          console.log('Confirmation error:', err.message || JSON.stringify(err));
        } else {
            navToHome();
        }
    });

    console.log(username)
}

function navToHome(){
    window.location.href = "register.html"
}

function navToRegister(){
    window.location.href = "register.html"
}