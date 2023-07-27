async function registerUser(){
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/users/register", {
      headers: {
        "Accept": "application/json",
        // "Authorization": `Bearer ${jwtToken}`,
      },
    });

    console.log(result)
}

async function loginUser(){
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/users/login", {
      headers: {
        "Accept": "application/json",
        // "Authorization": `Bearer ${jwtToken}`,
      },
    });

    console.log(result)
}