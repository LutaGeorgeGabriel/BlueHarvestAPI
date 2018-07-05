import React from 'react';
import axios from 'axios';
import UserRow from "../UserRow";
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow,} from 'material-ui/Table';

// created UserTable as a class in order to use the componentDidMount lifecycle method
class UserTable extends React.Component {
    constructor(props) {
        super(props);
    };

    componentDidMount() {
        axios.get('http://localhost:8080/fetch')
            .then((response) => {
                console.log(response.data);
                this.props.onUsersChange(response.data);
            })
            .catch((error) => {
                console.log("Error occurred when fetching the data ...", error);
            })
    }

    render() {
        console.log(this.props.users);
        return (
            <div>
                <Table>
                    <TableHeader>
                        <TableRow>
                            <TableHeaderColumn>ID</TableHeaderColumn>
                            <TableHeaderColumn>Name</TableHeaderColumn>
                            <TableHeaderColumn>Surname</TableHeaderColumn>
                            <TableHeaderColumn>Accounts</TableHeaderColumn>
                            <TableHeaderColumn>Balance</TableHeaderColumn>
                        </TableRow>
                    </TableHeader>
                    <TableBody>
                        {
                            this.props.users.map((user, index) => {
                                return <UserRow {...user} key={index}/>
                            })
                        }
                    </TableBody>
                </Table>
            </div>
        )
    }
};

export default UserTable;