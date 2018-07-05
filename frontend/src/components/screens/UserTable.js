import React from 'react';
import axios from 'axios';
import UserRow from "../UserRow";
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow,} from 'material-ui/Table';
import Service from "../service/Service";

// created UserTable as a class in order to use the componentDidMount lifecycle method
class UserTable extends React.Component {
    constructor(props) {
        super(props);
    };

    componentDidMount() {
        Service.get(this.props.onUsersChange);
    }

    render() {
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