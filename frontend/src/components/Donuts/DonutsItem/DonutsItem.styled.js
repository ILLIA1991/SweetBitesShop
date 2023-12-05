import styled from "@emotion/styled";
import { mq, colors } from "../../../utils";

export const Wraper = styled.div`
  width: 391px;
  height: 490px;
`;
export const Img = styled.img`
  width: 299px;
  height: 306.611px;
`;

export const Items = styled.li`
  display: flex;
  width: 389px;
  height: 412px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: ${colors.backgroundHeader};
`;
export const Title = styled.h2`
  margin-top: 15px;
  color: ${colors.primary};
  font-size: 28px;
  text-transform: uppercase;
`;
export const Span = styled.span`
  color: ${colors.primary};
  font-size: 25px;
  text-transform: uppercase;
`;
