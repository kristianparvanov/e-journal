import React from 'react';
import {HashRouter} from 'react-router-dom';
import RouterConfig from '../routerconfig';
import {StyledLink} from '../styles';

const Navigation = () => (
    <HashRouter>
        <div>
            <StyledLink to="/">Home </StyledLink>
            <StyledLink to="/movies">Movies </StyledLink>
            <StyledLink to="/series">Series </StyledLink>
            <StyledLink to="/upload">Updater </StyledLink>
            <StyledLink to="/login">Login </StyledLink>
            <RouterConfig/>
        </div>
    </HashRouter>
);

export default Navigation;