import React from "react";
import { DonutsItem } from "./DonutsItem/DonutsItem";
import { data } from "./data";
import { Wraper, Title, List } from "./Donuts.styled";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

export const Donuts = () => {
  const settings = {
    dots: false,
    arrows: false,
    infinite: true,
    autoplay: true,
    adaptiveHeight: true,
    speed: 700,
    autoplaySpeed: 2000,
    slidesToShow: 1,
    cssEase: "linear",
    responsive: [
      {
        breakpoint: 1440,
        settings: {
          slidesToShow: 3,
        },
      },
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  };

  return (
    <Wraper>
      <Title>Bestsellers</Title>
      <List>
        <Slider {...settings}>
          {data.map((donuts, i) => {
            return <DonutsItem key={i} {...donuts} />;
          })}
        </Slider>
      </List>
    </Wraper>
  );
};
