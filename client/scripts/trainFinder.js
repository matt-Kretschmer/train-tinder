const jwtToken = localStorage.getItem("jwt");
let data, trainSelected;
let likedTrains = [];

async function getTrainDetails() {
  likedTrains = await getUserLikedTrains();

  showLoadingAnimation();
  try {
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains/details", {
      headers: {
        "Accept": "application/json",
        "Authorization": `Bearer ${jwtToken}`,
      },
    });

    if(result.status === 401){
      window.location.replace('https://dnhcmoxb4x8e8.cloudfront.net/');
    }

    data = await result.json();

    let availableTrains = data.filter(
      (allTrains) =>
        !likedTrains.some((userTrains) => allTrains.name === userTrains.name)
    );
    if (availableTrains.length !== 0) {
      const randomIndex = Math.floor(Math.random() * availableTrains.length);
      trainSelected = availableTrains[randomIndex];

      document.querySelector("#train").src = trainSelected["imageUrl"];

      for (const x in trainSelected) {
        if (x != "trianDetailsId") {
          const element = document.getElementById(x);
          if (element) {
            element.textContent = trainSelected[x];
          }
        }
      }
      hideLoadingAnimation();
    } else {
      window.location.href('noTrains.html');
    }
  } catch (error) {
    hideLoadingAnimation();
    console.error(error);
    window.location.href = 'error.html';

  }
}

async function getUserLikedTrains() {
  try {
    showLoadingAnimation();
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains/likes", {
      headers: {
        "Accept": "application/json",
        "Authorization": `Bearer ${jwtToken}`,
      },
    });

    if(result.status === 401){
      hideLoadingAnimation();
      window.location.replace('https://dnhcmoxb4x8e8.cloudfront.net/');
    }

    hideLoadingAnimation();
    return await result.json();
  } catch (error) {
    hideLoadingAnimation();
    window.location.href = 'error.html' ;
  }
}

async function postTrainData(matched) {
  try {
    showLoadingAnimation();
    const response = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains", {
      method: "POST",
      headers: { "Authorization": `Bearer ${jwtToken}`,
    "Accept":"application/json",
    "Content-Type":"application/json"
    },
      body: JSON.stringify({
        trainDetailsId: trainSelected["trianDetailsId"],
        matched: matched,
      }),
    });

    if(response.status === 401){
      hideLoadingAnimation();
      window.location.replace('https://dnhcmoxb4x8e8.cloudfront.net/');
    }

    if (!response.ok) {
      hideLoadingAnimation();
      throw new Error("Failed response");
    }

    hideLoadingAnimation();
    getTrainDetails();
  } catch (error) {
    hideLoadingAnimation();
    console.error(error);
    window.location.href ='error.html';

  }
}

document.addEventListener("DOMContentLoaded", async () => {
  await getTrainDetails();
});
