import styled from "@emotion/styled";
import { mq, colors } from "../../utils";

export const Section = styled.section`
  padding-left: 30px;
  padding-right: 30px;
  background-color: ${colors.pimkLight};
  ${mq.tablet} {
    padding-top: 90px;
    padding-left: 80px;
    padding-right: 80px;
    padding-bottom: 90px;
  }
`;
export const WrapImg = styled.div``;
export const Img = styled.img`
  width: 411px;
  height: 411px;
`;
export const Title = styled.h2`
  color: ${colors.primary};
  font-size: 75px;
  text-transform: uppercase;
  margin-bottom: 35px;
`;
export const Descr = styled.p`
  width: 420px;
  color: ${colors.primary};
  font-size: 26px;
  ${mq.tablet} {
    width: 738px;
  }
`;
export const Wraper = styled.div`
  display: flex;
  justify-content: space-between;
`;
export const WrapText = styled.div``;
