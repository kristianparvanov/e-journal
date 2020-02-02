import styled from 'styled-components';
import {Link} from 'react-router-dom';
import React from 'react';
import {
    PageContainer,
    PageFooter,
    PageHeader,
    PageMain,
    PageNav,
    PageSide
} from "./pageStyles";

const Title = styled.h1`
  font-size: 2em;
  text-align: center;
  color: palevioletred;
`;

const StyledLink = styled(Link)`
      align-self:center;
      padding:1rem 1rem;
      margin:0 1rem;
`;

const DivMainContent = styled.div`
  margin-top:5% !important;
`;

const StyledMainHeader = styled.h1`
  margin-left: 50%;
`;

export {
    Title,
    StyledLink,
    PageContainer,
    PageHeader,
    PageNav,
    PageMain,
    PageFooter,
    PageSide,
    DivMainContent,
    StyledMainHeader,
}
