import React from 'react';
import {DivMainContent} from '../styles';
import MoviesTable from './MoviesTable';

const Movies = () => (
    <DivMainContent>
        <h3>Movie List</h3>
        <MoviesTable/>
    </DivMainContent>
);

export default Movies;
