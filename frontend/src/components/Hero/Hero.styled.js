import styled from "@emotion/styled";
import { mq, colors } from "../../utils";

export const Wraper = styled.section`
  padding-left: 30px;
  padding-right: 30px;
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
  top: 330px;
  color: #fcf3f6;
  font-family: Gabarito;
  font-size: 85px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  text-transform: uppercase;
`;
export const Button = styled.button`
  position: absolute;
  top: 587px;
  display: flex;
  width: 223px;
  height: 76px;
  justify-content: center;
  align-items: center;
  gap: 10px;
  background-color: transparent;
  border-radius: 70px;
  border: 4px solid #fcf3f6;
`;
export const Span = styled.span`
  color: ${colors.white};
  font-family: Gabarito;
  font-size: 28px;
`;
export const Img = styled.img`
  display: flex;
  margin-left: auto;
  width: 519px;
  height: 491px;
  ${mq.tablet} {
    width: 785px;
    height: 721.817px;
  }
`;
