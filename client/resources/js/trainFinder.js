const dummyData = [
  {
    name: "thomas",
    about:
      " Hi, i’m thomas, its lonely being the dankest engine in town. Why don’t we grab a smoke together and see where things can chug along, choo choo.",
    likes: "Raves and premium oil",
    dislikes: "Environmentalists, and non train enjoyers",
  },
  {
    name: "bob",
    about:
      "don’t we grab a smoke together and see where things can chug along, choo choo.",
    likes: "Raves and premium oil",
    dislikes: "Environmentalists, and non train enjoyers",
  },
  {
    name: "mary",
    about:
      " Hi, i’m thomas, its lonely being the dankest engine in town. Why don’t we grab a smoke together and see where things can chug along, choo choo.",
    likes: "Raves and premium oil",
    dislikes: "Environmentalists, and non train enjoyers",
  },
  {
    name: "adam",
    about:
      " Hi, i’m thomas, its lonely being the dankest engine in town. Why don’t we grab a smoke together and see where things can chug along, choo choo.",
    likes: "Raves and premium oil",
    dislikes: "Environmentalists, and non train enjoyers",
  },
]; //temporary

document.addEventListener("DOMContentLoaded", async () => {
  const randomIndex = Math.floor(Math.random() * dummyData.length);
  const data = dummyData[randomIndex];

  for (const x in data) {
    document.getElementById(x).textContent = data[x];
  }
});
