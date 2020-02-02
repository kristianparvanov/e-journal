import styled from 'styled-components';

const PageContainer = styled.div`
 display: grid;
  grid-template-areas:
    "header header header"
    "nav content side"
    "footer footer footer";
  grid-template-columns: 100px 1fr 100px;
  grid-template-rows: auto 1fr auto;
  grid-gap: 0px;
  text-align:center;
  height: 100vh;
  background-color: #whitesmoke;
`;

const PageHeader = styled.header`
  display: flex;
  grid-area: header;
  justify-content: space-between;
  align-items: center
  text-align:center;;
`;

const PageNav = styled.nav`
  grid-area: nav;
  margin-left: 0.5rem;
  text-align:center;
`;


const PageMain = styled.main`
  grid-area: content;
  text-align:center;
  padding-top:3%;
`;

const PageSide = styled.aside`
  grid-area: side;
  margin-right: 0.5rem;
  text-align:center;
`;

const PageFooter = styled.footer`
  grid-area: footer;
  text-align:center;
`;

export {
    PageFooter,
    PageSide,
    PageMain,
    PageNav,
    PageHeader,
    PageContainer
}