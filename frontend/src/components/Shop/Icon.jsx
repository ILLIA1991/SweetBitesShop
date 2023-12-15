import arrow from "../../img/arrow-defs.svg";

const Icon = () => {
  return (
    <span>
      <svg width="20" height="20">
        <use xlinkHref={`${arrow}#icon-Vector`}></use>
      </svg>
    </span>
  );
};

export default Icon;
