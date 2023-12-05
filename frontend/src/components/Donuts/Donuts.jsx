import React from "react";
import { DonutsItem } from "./DonutsItem/DonutsItem";
import { data } from "./data";
import { Wraper, Title, List } from "./Donuts.styled";

export const Donuts = () => {
  return (
    <Wraper>
      <Title>Bestsellers</Title>
      <List>
        {data.map((donuts, i) => {
          return <DonutsItem key={i} {...donuts} />;
        })}
      </List>
    </Wraper>
  );
};
