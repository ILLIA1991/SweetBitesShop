import { Header } from "../Header/Header";
import { Hero } from "../Hero/Hero";
import { Donuts } from "../Donuts/Donuts";
import { About } from "../About/About";
import "./App.css";

export const App = () => {
  return (
    <>
      <Header />
      <Hero />
      <Donuts />
      <About />
    </>
  );
};
