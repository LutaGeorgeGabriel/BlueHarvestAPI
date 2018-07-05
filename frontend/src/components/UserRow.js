import React from 'react';

import {TableRow, TableRowColumn,} from 'material-ui/Table';

const UserRow = ({customerID, name, surname, accounts}) => {
    let totalBalance = accounts.length !== 0 ? accounts.reduce((total, account) => {
        return total += account.balance;
    },0) : 0;

    return (
        <TableRow>
            <TableRowColumn>{customerID}</TableRowColumn>
            <TableRowColumn>{name}</TableRowColumn>
            <TableRowColumn>{surname}</TableRowColumn>
            <TableRowColumn>{accounts.length}</TableRowColumn>
            <TableRowColumn>{totalBalance}</TableRowColumn>
        </TableRow>
    );
};

export default UserRow;