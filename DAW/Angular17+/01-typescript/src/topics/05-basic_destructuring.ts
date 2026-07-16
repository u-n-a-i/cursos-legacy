//* Objetos
// interface AudioPlayer {
//   audioPlayer: number;
//   songDuration: number;
//   song: string;
//   details: Details;
// }

// interface Details {
//   author: string;
//   year: number;
// }

// const audioPlayer: AudioPlayer = {
//   audioPlayer: 90,
//   songDuration: 36,
//   song: "Mi canción",
//   details: {
//     author: "Yo",
//     year: 2000,
//   },
// };

// const { song } = audioPlayer;

// console.log({ song });

// console.log("Song: ", audioPlayer.song);
// console.log("Author: ", audioPlayer.details.author);

// const { author } = audioPlayer.details;
// console.log({ author });

//* Arreglos

const dbz: string[] = ["Gohan", "Turnks", "Goku"];

const [gohan] = dbz;
console.log({ gohan });

const [, , goku] = dbz;
console.log({ goku });

export {};
