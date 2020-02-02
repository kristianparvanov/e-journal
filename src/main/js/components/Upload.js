import React from 'react';
import {DropzoneComponent} from 'react-dropzone-component';
import {DivMainContent} from '../styles';

export default class Upload extends React.Component {
    constructor(props) {
        super(props);

        this.djsConfig = {
        };

        this.componentConfig = {
            iconFiletypes: ['db'],
            showFiletypeIcon: true,
            postUrl: '#'
        };
    }

    render() {
        return <DivMainContent>
            <DropzoneComponent config={this.componentConfig} djsConfig={this.djsConfig}/>
        </DivMainContent>
    }
}