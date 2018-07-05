import React from 'react';
import {List, ListItem} from 'material-ui/List';

import Key from 'material-ui/svg-icons/communication/vpn-key';
import Name from 'material-ui/svg-icons/action/face';
import Credit from 'material-ui/svg-icons/action/euro-symbol';
import Accounts from 'material-ui/svg-icons/action/account-balance-wallet';
import Transactions from 'material-ui/svg-icons/action/credit-card';

const User = ({customerID, name, surname, initialCredit, accounts, transactions}) => {

    let transactionDetails = transactions.reduce((transactions, transaction) => {
        transactions.push({
            from: transaction.fromAccount,
            to: transaction.toAccount,
            amount: amount
        })
    },[]);

    return(
        <div>
            <List style={{width: '50%'}}>
                <ListItem primaryText={customerID} leftIcon={<Key />} />
                <ListItem primaryText={name + surname} leftIcon={<Name />} />
                <ListItem primaryText={initialCredit} leftIcon={<Credit />} />
                <ListItem primaryText={accounts? JSON.stringify(accounts) : ''} leftIcon={<Accounts />} />
                <ListItem primaryText={transactions? JSON.stringify(transactions) : ''} leftIcon={<Transactions />} />
            </List>
        </div>
    );
};

export default User;