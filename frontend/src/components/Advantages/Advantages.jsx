import React from "react";
import sprite from "../../img/symbol-defs.svg";
import { Wraper, List, Item, Span, SpanSec } from "./Advantages.styled";

export const Advantages = () => {
  return (
    <Wraper>
      <List>
        <Item>
          <svg width="38" height="38">
            <use href={sprite + `#icon-banana`}></use>
          </svg>
          <Span>
            Exotic <SpanSec>fruits</SpanSec>
          </Span>
        </Item>
        <Item>
          <svg width="38" height="38">
            <use href={sprite + `#icon-gluten`}></use>
          </svg>
          <Span>
            Sugar <SpanSec>free</SpanSec>
          </Span>
        </Item>
        <Item>
          <svg width="38" height="38">
            <use href={sprite + `#icon-vegan`}></use>
          </svg>
          <Span>
            Gluten <SpanSec>free</SpanSec>
          </Span>
        </Item>
        <Item>
          <svg width="38" height="38">
            <use href={sprite + `#icon-sugar`}></use>
          </svg>
          <Span>Vegan</Span>
        </Item>
      </List>
    </Wraper>
  );
};
