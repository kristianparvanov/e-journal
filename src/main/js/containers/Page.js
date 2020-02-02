import Navigation from './Navigation';
import {PageContainer, PageFooter, PageHeader, PageMain, PageNav, PageSide, StyledMainHeader} from '../styles';
import React from 'react';

const Page = () => (
    <PageContainer>
        <PageHeader>
            <StyledMainHeader>Plex</StyledMainHeader>
        </PageHeader>
        <PageNav>

        </PageNav>
        <PageMain>
            <Navigation/>
        </PageMain>
        <PageSide>

        </PageSide>
        <PageFooter>
            &copy; Copyright ~
        </PageFooter>
    </PageContainer>
);

export default Page;