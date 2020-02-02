import Home from './components/Home';
import Upload from './components/Upload';
import Movies from './components/Movies';
import Movie from './components/Movie';
import Login from './components/Login'

const routes = [
    {
        path: '/',
        exact: true,
        component: Home,
        id: 'home',
    },
    {
        path: '/home',
        component: Home,
        id: 'home',
    },
    {
        path: '/movies',
        component: Movies,
        exact: true,
        id: 'movies'
    },
    {
        path: '/upload',
        component: Upload,
        id: 'upload',
    },
    {
        path: '/movies/:id',
        component: Movie,
        exact: true,
        id: 'moviePage',
    },
    {
        path: '/login',
        component: Login,
        exact: true,
        id: 'login',
    }
];

export default routes;
