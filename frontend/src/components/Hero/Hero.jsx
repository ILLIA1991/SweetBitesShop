import React from "react";
import { Wraper, Title, Button, Img, Span } from "./Hero.styled";
import hero from "../../img/hero.png";
import sprite from "../../img/symbol-defs.svg";

export const Hero = () => {
  return (
    <>
      <Wraper>
        <Title>
          Cakes for any <br />
          taste
        </Title>

        <Img src={hero} alt="hero" />
        <Button type="submit">
          <Span>Buy Now</Span>
          <svg width="28" height="28">
            <use href={sprite + `#icon-arrow`}></use>
          </svg>
        </Button>
      </Wraper>
    </>
  );
};
