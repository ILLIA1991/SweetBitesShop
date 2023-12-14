import Filter from "../../components/Shop/Filter";
import ProductItem from "../../components/Shop/ProductItem";
import {
  Button,
  Container,
  FlexFilterItem,
  FlexHeading,
  FlexItemContainer,
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
            <Filter />
            <Filter />
          </FlexFilterItem>
          <ProductList>
            <ProductItem />
            <ProductItem />
            <ProductItem />
            <ProductItem />
          </ProductList>
        </FlexItemContainer>
      </Container>
    </Section>
  );
};

export default ShopMainContent;
