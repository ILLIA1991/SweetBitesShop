import { Img, Items, Title, Span, Wraper } from "./DonutsItem.styled";

export const DonutsItem = ({ title, imgUrl, price }) => {
  return (
    <>
      <Items>
        <Wraper>
          <Img src={imgUrl} alt="donuts" />
        </Wraper>
        <Title>{title}</Title>
        <Span>{price}</Span>
      </Items>
    </>
  );
};
