import Filter from "../../components/Shop/Filter";
import ProductItem from "../../components/Shop/ProductItem";
import {
  Button,
  Container,
  FlexHeading,
  FlexItemContainer,
  Section,
} from "./Shop.styled";

const ShopMainContent = () => {
  return (
    <Section>
      <Container>
        <FlexHeading>
          <h2>This is shop</h2>
          <Button>Sorted by</Button>
        </FlexHeading>
        <FlexItemContainer>
          <div>
            <Filter />
            <Filter />
          </div>
          <div>
            <ProductItem />
          </div>
        </FlexItemContainer>
      </Container>
    </Section>
  );
};

export default ShopMainContent;
