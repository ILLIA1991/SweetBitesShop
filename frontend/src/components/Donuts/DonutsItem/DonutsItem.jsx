import { Img, Items, Title, Span, Wraper } from "./DonutsItem.styled";

export const DonutsItem = ({ title, imgUrl, price }) => {
  return (
    <Wraper>
      <Items>
        <Img src={imgUrl} alt="donuts" />
      </Items>
      <Title>{title}</Title>
      <Span>{price}</Span>
    </Wraper>
  );
};
