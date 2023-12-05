import styled from "@emotion/styled";
import { mq, colors } from "../../utils";

export const Wraper = styled.div`
  padding-left: 80px;
  padding-right: 80px;
  background-color: ${colors.pimkLight};
`;
export const Title = styled.h2`
  color: ${colors.primary};
  font-family: Gabarito;
  font-size: 75px;
  font-style: normal;
  font-weight: 700;
  line-height: normal;
  text-transform: uppercase;
  padding-top: 90px;
  padding-bottom: 30px;
`;
export const List = styled.ul`
  display: flex;
  justify-content: space-between;
`;
