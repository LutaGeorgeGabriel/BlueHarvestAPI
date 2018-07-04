import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import FlatButton from 'material-ui/FlatButton';
import Service from './service/Service'
import User from './User'
import UserCreateForm from './UserCreateForm'

import '../resources/App.css';

const App = () => (
    <div className="App">
        <MuiThemeProvider>
            <UserCreateForm />
            <FlatButton
                label="GET"
                secondary={true}
                onClick={() => Service.fetch()}/>
            <FlatButton
                label="UPDATE"
                secondary={true}
                onClick={() => Service.update()}/>
            <User />
        </MuiThemeProvider>
    </div>
);


export default App;
