import React, { useState } from "react";
import { AiOutlineCloseCircle, AiOutlineFullscreen } from "react-icons/ai";
import sprite from "../../img/symbol-defs.svg";
import { useNavigate } from "react-router-dom";
import {
  HeaderContainer,
  Logo,
  Image,
  HeaderLogo,
  Span,
  Nav,
  NavList,
  NavItem,
  NavLink,
  CloseButton,
  ToggleButton,
} from "./Header.styled";

export const Header = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const navigate = useNavigate();

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  const handleNavLinkClick = (to) => {
    navigate(to);
    setIsMenuOpen(false);
  };

  return (
    <HeaderContainer>
      <Logo>
        <HeaderLogo onClick={() => handleNavLinkClick("/")}>
          Sweet{" "}
          <svg width="20" height="20">
            <use href={sprite + `#icon-logo`}></use>
          </svg>
          <br />
          <Span>BitesShop</Span>
        </HeaderLogo>
      </Logo>

      <Nav id="nav-menu" className={isMenuOpen ? "show" : ""}>
        <CloseButton>
          <AiOutlineCloseCircle
            name="close-circle-outline"
            onClick={toggleMenu}
          ></AiOutlineCloseCircle>
        </CloseButton>
        <NavList>
          <NavItem>
            <NavLink onClick={() => handleNavLinkClick("/")}>Home</NavLink>
          </NavItem>
          <NavItem>
            <NavLink onClick={() => handleNavLinkClick("/about")}>
              About
            </NavLink>
          </NavItem>
          <NavItem>
            <NavLink onClick={() => handleNavLinkClick("/shop")}>Shop</NavLink>
          </NavItem>
        </NavList>
      </Nav>
      <ToggleButton>
        <AiOutlineFullscreen
          name="menu-outline"
          onClick={toggleMenu}
        ></AiOutlineFullscreen>
      </ToggleButton>
    </HeaderContainer>
  );
};
