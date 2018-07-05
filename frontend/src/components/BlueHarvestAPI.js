import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import UserTable from './screens/UserTable';
import leftLogo from '../resources/left-logo.png'
import rightLogo from '../resources/right-logo.png'
import UserCreateForm from './screens/UserCreateForm';
import UserUpdateForm from './screens/UserUpdateForm';

class BlueHarvestAPI extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userCreateForm: {
                name: '',
                surname: ''
            },
            allUsersInfo: [],
            userUpdateWithCredit: {
                customerID: '',
                initialCredit: ''
            }
        };

        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleSurnameChange = this.handleSurnameChange.bind(this);
        this.handleUsersChange = this.handleUsersChange.bind(this);
        this.handleCustomerIDChange = this.handleCustomerIDChange.bind(this);
        this.handleInitialCreditChange = this.handleInitialCreditChange.bind(this);
    }

    handleNameChange(event, value) {
        this.setState({
            userCreateForm: Object.assign({}, this.state.userCreateForm, {name: value})
        })
    }

    handleSurnameChange(event, value) {
        this.setState({
            userCreateForm: Object.assign({}, this.state.userCreateForm, {surname: value})
        })
    }

    handleCustomerIDChange(event, value) {
        this.setState({
            userUpdateWithCredit: Object.assign({}, this.state.userUpdateWithCredit, {customerID: value})
        })
    }

    handleInitialCreditChange(event, value) {
        this.setState({
            userUpdateWithCredit: Object.assign({}, this.state.userUpdateWithCredit, {initialCredit: value})
        })
    }

    handleUsersChange(users) {
        debugger
        let prevState = Object.assign({}, this.state);
        let prevUsers = prevState.allUsersInfo;
        let newUsers = [...prevUsers, ...users];
        this.setState({
            allUsersInfo: [...newUsers]
        })
    }

    render() {
        return (
            <div className="App">
                <MuiThemeProvider>
                    <div>
                        <div style={{marginBottom: "5%"}}>
                            <img src={leftLogo}  alt="blue-harvest"/>
                            <img src={rightLogo} alt="blue-harvest"/>
                        </div>
                        <UserTable
                            users={this.state.allUsersInfo}
                            onUsersChange={this.handleUsersChange}/>
                        <UserCreateForm
                            onNameChange={this.handleNameChange}
                            onSurnameChange={this.handleSurnameChange}
                            name={this.state.userCreateForm.name}
                            surname={this.state.userCreateForm.surname}/>
                        <UserUpdateForm
                            onCustomerIDChange={this.handleCustomerIDChange}
                            onInitialCreditChange={this.handleInitialCreditChange}
                            customerID={this.state.userUpdateWithCredit.customerID}
                            initialCredit={this.state.userUpdateWithCredit.initialCredit}/>
                    </div>
                </MuiThemeProvider>
            </div>
        )
    }
}

export default BlueHarvestAPI;