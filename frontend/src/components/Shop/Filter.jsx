import arrow from "../../img/arrow-defs.svg";
import { StyledFilter } from "./Shop.styled";

const Filter = () => {
  return (
    <StyledFilter>
      <div>
        <h3>
          Categories
          <span>
            <svg width="20" height="20">
              <use xlinkHref={`${arrow}#icon-Vector`}></use>
            </svg>
          </span>
        </h3>
      </div>
      <ul>
        <li>
          {/* <input type="checkout" /> */}
          <p>Banana</p>
        </li>
        <li>
          <p>Strawberry</p>
        </li>
        <li>
          <p>Cherry</p>
        </li>
        <li>
          <p>Chocolate</p>
        </li>
      </ul>
    </StyledFilter>
  );
};

export default Filter;
