/** @type {import('tailwindcss').config} */
export default {
  content: ["./index.html", ".src/**/*.{js,ts,jsx,tsx,html}"],
  theme: {
    extends: {
      colors: {
        primary: "#FF6363",
        secondary: {
          100: "#E2E2D5",
          200: "#888883",
        },
      },
    },
  },
  plugins: [require("@tailwindcss/typography")],
};
