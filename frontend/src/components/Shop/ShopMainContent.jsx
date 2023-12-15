import Filter from "../../components/Shop/Filter";
import ProductItem from "../../components/Shop/ProductItem";
import {
  Button,
  Container,
  FlexFilterItem,
  FlexHeading,
  FlexItemContainer,
  LoadMoreStyledContainer,
  ProductList,
  Section,
} from "./Shop.styled";

import arrow from "../../img/arrow-defs.svg";

const ShopMainContent = () => {
  return (
    <Section>
      <Container>
        <FlexHeading>
          <h2>Shop</h2>
          <Button>
            Sorted by{" "}
            <span>
              <svg width="20" height="20">
                <use xlinkHref={`${arrow}#icon-Vector`}></use>
              </svg>
            </span>
          </Button>
        </FlexHeading>
        <FlexItemContainer>
          <FlexFilterItem>
            <Filter title="Categories">
              <ul>
                <li>
                  <input type="checkbox" />
                  <p>Donuts</p>
                </li>
                <li>
                  <p>Macaroon</p>
                </li>
                <li>
                  <p>Cupcakes</p>
                </li>
                <li>
                  <p>Brownie</p>
                </li>
              </ul>
            </Filter>
            <Filter title="Filters">
              <ul>
                <li>
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
            </Filter>
          </FlexFilterItem>
          <LoadMoreStyledContainer>
            <ProductList>
              <ProductItem />
              <ProductItem />
              <ProductItem />
              <ProductItem />
            </ProductList>
            <button>Load more</button>
          </LoadMoreStyledContainer>
        </FlexItemContainer>
      </Container>
    </Section>
  );
};

export default ShopMainContent;
