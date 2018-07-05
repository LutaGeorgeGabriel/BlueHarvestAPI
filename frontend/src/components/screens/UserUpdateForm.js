import React from 'react';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
import Service from "../service/Service";

const style = {
    floatingLabelColor: {
        color: "#000"
    },
    fieldMargin: {
        marginLeft: "25px",
    }
};

const UserUpdateForm =({customerID, initialCredit, onCustomerIDChange, onInitialCreditChange}) => {

    return (
        <div>
            <TextField
                floatingLabelText="Customer ID"
                underlineShow={false}
                value={customerID}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onCustomerIDChange(event, value)}/>
            <TextField
                style={style.fieldMargin}
                floatingLabelText="Initial Credit"
                underlineShow={false}
                value={initialCredit}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onInitialCreditChange(event, value)}/>
            <FlatButton
                style={style.fieldMargin}
                label="UPDATE USER"
                secondary={true}
                onClick={() => Service.update({
                        customerID: customerID
                    }, initialCredit)}/>
        </div>
    )
};

export default UserUpdateForm;