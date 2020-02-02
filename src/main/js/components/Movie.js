import React from 'react';
import axios from "axios/index";

class Movie extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        axios.get(`movie`)
            .then(res => {
                const movie = res.data;
                this.setState({
                    data: movie,
                });
            })
            .catch(function (error) {
                this.setState({
                    data: []
                })
                console.error(error);
            })
    }

    render() {
        const data = this.state.data;
        return (
            <div>
                <div>
                    <div>
                        <div>Rating: {Math.round(Number(data.rating))} /
                            10
                        </div>
                        <div>Year: {data.year}</div>
                        <div>Genre: {data.genres}</div>
                        <div>Duration: {Math.round((Number(data.duration) / 60000))} min</div>
                    </div>
                </div>
                <div>
                    <h1>{data.title}</h1>
                    <div><img
                        src={data.posterUrl}/>
                    </div>
                    <div>Video
                        Codec
                    </div>
                    <div>
                        <div>
                            <div>DIRECTOR {data.director}</div>
                            <div>WRITER {data.writer}</div>
                            <div>AUDIO {data.audioLanguage}</div>
                            <div>SUBTITLE {data.subtitlesLanguage}</div>
                        </div>
                    </div>
                    <div>
                        <div>{data.description}</div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Movie;
