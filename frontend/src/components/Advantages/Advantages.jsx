import sprite from "../../img/symbol-defs.svg";
import { Wraper, List, Item, Span, SpanSec } from "./Advantages.styled";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

export const Advantages = () => {
  const settings = {
    dots: false,
    arrows: false,
    infinite: true,
    autoplay: true,
    adaptiveHeight: true,
    speed: 500,
    autoplaySpeed: 2000,
    slidesToShow: 3,
    cssEase: "linear",
  };
  return (
    <Wraper>
      <List>
        <Slider {...settings}>
          {icons.map((icon, index) => (
            <Item key={index}>
              <svg width="38" height="38">
                <use href={sprite + icon}></use>
              </svg>
              <Span>
                {labels[index]} <SpanSec>{subLabels[index]}</SpanSec>
              </Span>
            </Item>
          ))}
        </Slider>
      </List>
    </Wraper>
  );
};

const icons = [
  "#icon-banana",
  "#icon-gluten",
  "#icon-vegan",
  "#icon-sugar",
  "#icon-banana",
  "#icon-gluten",
  "#icon-vegan",
  "#icon-sugar",
];
const labels = [
  "Exotic",
  "Sugar",
  "Gluten",
  "Vegan",
  "Exotic",
  "Sugar",
  "Gluten",
  "Vegan",
];
const subLabels = ["fruits", "free", "free", "fruits", "free", "free"];

export default Advantages;
