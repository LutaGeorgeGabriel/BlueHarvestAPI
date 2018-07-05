import React from 'react';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
import Service from "../service/Service";

const style = {
    floatingLabelColor: {
        color: "#000"
    }
};

const UserUpdateWithCredit =({customerID, initialCredit, onCustomerIDChange, onInitialCreditChange}) => {

    return (
        <div style={{backgroundColor: "yellow"}}>
            <TextField
                floatingLabelText="Customer ID"
                underlineShow={false}
                value={customerID}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onCustomerIDChange(event, value)}/>
            <TextField
                floatingLabelText="Initial Credit"
                underlineShow={false}
                value={initialCredit}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onInitialCreditChange(event, value)}/>
            <FlatButton
                label="UPDATE"
                secondary={true}
                onClick={() => Service.update({
                        customerID: customerID
                    }, initialCredit)}/>
        </div>
    )
};

export default UserUpdateWithCredit;