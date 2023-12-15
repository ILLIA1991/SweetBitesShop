import Icon from "./Icon";
import { StyledFilter } from "./Shop.styled";

const Filter = ({ title, children }) => {
  return (
    <StyledFilter>
      <div>
        <h3>
          {title}
          <Icon />
        </h3>
        {children}
      </div>
    </StyledFilter>
  );
};

export default Filter;
