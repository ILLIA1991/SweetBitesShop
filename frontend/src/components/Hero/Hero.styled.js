import styled from "@emotion/styled";
import { mq, colors } from "../../utils";
import hero from "../../img/hero-mob.png";
import hero2 from "../../img/hero-tabl.png";

export const Wraper = styled.section`
  padding-left: 30px;
  height: 692px;
  background-color: ${colors.backgroundHeader};
  ${mq.tablet} {
    padding-left: 80px;
    padding-right: 80px;
    height: 960px;
  }
`;
export const Title = styled.h1`
  position: absolute;
  top: 290px;
  left: 30px;
  color: #fcf3f6;
  font-size: 50px;
  text-transform: uppercase;
  text-transform: uppercase;
  ${mq.tablet} {
    top: 330px;
    font-size: 85px;
  }
`;
export const Button = styled.button`
  position: absolute;
  top: 460px;
  display: flex;
  width: 223px;
  height: 76px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  background-color: transparent;
  border-radius: 70px;
  border: 4px solid #fcf3f6;
  ${mq.tablet} {
    top: 587px;
  }
`;
export const Span = styled.span`
  color: ${colors.white};
  font-family: Gabarito;
  font-size: 28px;
`;

export const Img = styled.div`
  margin-left: 30px;
  height: 491px;
  background-image: url(${hero});
  background-repeat: no-repeat;
  background-position: center;
  background-size: contain;
  ${mq.tablet} {
    background-image: url(${hero2});
    width: 519px;
    height: 491px;
  }
`;
