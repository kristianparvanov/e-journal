import React from 'react';
import axios from 'axios';
import ReactTable from 'react-table';
import {Link} from 'react-router-dom';
import 'react-table/react-table.css'

const columns = [{
    Header: 'Title',
    accessor: 'title',
    filterable: true,
    Cell: (cellInfo) => (
        <Link style={{textDecoration: 'none'}}
              to={`/movies/${cellInfo.row.id}`}>{cellInfo.row.title}</Link>

    ),
    sortable: true
}, {
    Header: 'Release date',
    accessor: 'year',
    width: 150,
    filterable: false
}, {
    Header: 'Status',
    accessor: 'status',
    width: 150,
    filterable: false
}, {
    Header: 'ID',
    accessor: "id",
    show: false
}, {
    Header: 'Movie Poster',
    accessor: "poster",
    filterable: false,
    show: true,
    Cell: (cellInfo) => (
        <img style={{width: "50%"}}
             src={cellInfo.row.poster}/>
    )
}
];
const pageSize = 6; //hard-coded value, please change according to the implementation of your backend!

class MoviesTable extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: [],
            pages: 4,
            loading: true
        };
    }

    pageChange(currPage) {
        this.setState({loading: true})
        axios.get('movies?page=' + (currPage), {
            page: currPage.page,
            pageSize: currPage.pageSize,
            sorted: currPage.sorted,
            filtered: currPage.filtered
        })
            .then((res) => {
                this.setState({
                    data: res.data,
                    loading: false,
                    page: res.data[0].page
                })
            })
            .catch(function (error) {
                this.setState({
                    data: [],
                    loading: true
                })
                console.error(error);
            })
    }

    search(column) {
        console.log("Good place to call fetch results from search query");
    }

    componentDidMount() {
        axios.get(`movies`)
            .then(res => {
                const movies = res.data
                this.setState({
                    data: movies,
                    loading: false,
                    pages: 4 //hardcoded value !!
                });
            })
            .catch(function (error) {
            this.setState({
                data: [],
                loading: true

            })
            console.error(error);
        })
    }

    render() {
        return <ReactTable
            data={this.state.data}
            pages={this.state.pages}
            loading={this.state.loading}
            manual
            columns={columns}
            defaultPageSize={pageSize}
            showPageSizeOptions={false}
            filterable
            onFilteredChange={(column) => this.search(column)}
            onPageChange={(currPage) => this.pageChange(currPage)}
        />
    }
}

export default MoviesTable;