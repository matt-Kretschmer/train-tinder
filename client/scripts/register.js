const poolData = {
    UserPoolId: 'eu-west-1_BZAu5yKxc',      // Replace with your actual User Pool ID
    ClientId: 'l9lu2cspu2ago5vmv9b05l3ub',       // Replace with your actual App Client ID
};

const userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);

function registerUser(event) {
    event.preventDefault();
    try{

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const email = document.getElementById('email').value;
        // Add other form field values as needed
        
        const attributeList = [
            new AmazonCognitoIdentity.CognitoUserAttribute({ Name: 'email', Value: email }),
            new AmazonCognitoIdentity.CognitoUserAttribute({ Name: 'preferred_username', Value: username }),
            // Add other attributes as needed
        ];
    
        userPool.signUp(username, password, attributeList, null, function (err, result) {
        if (err) {
            console.error('Error registering user:', err.message || JSON.stringify(err));
            return;
        }else{

            console.log('User registered successfully. Confirmation email sent:', result.user);
            togglePopup()
        }
        // You can redirect the user to a confirmation page or perform other actions here.
        });
    }catch(e){
        console.log(e)
    }
}

function togglePopup() {
    var overlay = document.getElementById('popupOverlay');
    overlay.style.display = overlay.style.display === 'block' ? 'none' : 'block';
}

function authorizeUser(event){
    event.preventDefault();
}