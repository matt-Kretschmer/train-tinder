const jwtToken = localStorage.getItem("jwt");
let data, trainSelected;
let likedTrains = [];

async function getTrainDetails() {
  likedTrains = await getUserLikedTrains();

  try {
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains/details", {
      headers: {
        Accept: "application/json",
        Authorization: `Bearer ${jwtToken}`,
      },
    });
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
    } else {
      alert("no trains"); //to redirect to page maybe
    }
  } catch (error) {
    console.error(error);
  }
}

async function getUserLikedTrains() {
  try {
    const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains/likes", {
      headers: {
        Accept: "application/json",
        Authorization: `Bearer ${jwtToken}`,
      },
    });
    return await result.json();
  } catch (error) {
    console.error(error);
  }
}

async function postTrainData(matched) {
  try {
    const response = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains", {
      method: "POST",
      headers: { Authorization: `Bearer ${jwtToken}` },
      body: JSON.stringify({
        trianDetailsId: trainSelected["trianDetailsId"],
        matched: matched,
      }),
    });

    if (!response.ok) {
      throw new Error("Failed response");
    }

    await getTrainDetails();
  } catch (error) {
    console.error(error);
  }
}
document.addEventListener("DOMContentLoaded", async () => {
  await getTrainDetails();
});

document.querySelector("#likeButton").addEventListener("click", async () => {
  postTrainData(true);
});

document.querySelector("#dislikeButton").addEventListener("click", async () => {
  postTrainData(false);
});
