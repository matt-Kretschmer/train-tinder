const jwtToken = sessionStorage.getItem('jwt');
let currentTrainIndex = 0;
let likedTrains = [];

const fetchLikedTrains = async () => {
    
    try {
        showLoadingAnimation();
        const result = await fetch("https://iy5c8q37pq.eu-west-1.awsapprunner.com/trains/likes", {
            headers: {
                "Accept": "application/json",
                "Authorization": `Bearer ${jwtToken}`,
            },
        });

        if(result.status === 401 ){
            hideLoadingAnimation();
            window.location.replace('https://dnhcmoxb4x8e8.cloudfront.net/');
        };

        likedTrains = await result.json();
        hideLoadingAnimation();
        await getLikedTrainProfile();
        
    } catch (error) {
        console.error(error);
        window.location.href('noTrains.html');
    }
};

const nextLikedProfile = async () => {
    if(currentTrainIndex < likedTrains.length - 1) {
        currentTrainIndex++;
        await getLikedTrainProfile();
    }
};

const previousLikedProfile = async () => {
    if(currentTrainIndex > 0) {
        currentTrainIndex--;
        await getLikedTrainProfile();
    }
};

const getLikedTrainProfile = async () => {
    if(likedTrains.length === 0) {
        window.location.href = 'noTrains.html';
    }
    const currentProfile = likedTrains[currentTrainIndex];

    // Main section
    document.getElementById('train').src = currentProfile.imageUrl;

    // Details section
    document.getElementById('like-train-name').innerText = currentProfile.name;
    document.getElementById('about').innerText = currentProfile.about;
    document.getElementById('likes').innerText = currentProfile.likes;
    document.getElementById('dislikes').innerText = currentProfile.dislikes;
};

document.addEventListener("DOMContentLoaded", async () => {
    await fetchLikedTrains();
});
