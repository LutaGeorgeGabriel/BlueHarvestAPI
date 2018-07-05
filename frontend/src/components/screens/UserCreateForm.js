import React from 'react';
import TextField from 'material-ui/TextField';
import FlatButton from 'material-ui/FlatButton';
import Service from '../service/Service'

const style = {
    floatingLabelColor: {
        color: "#000"
    },
    fieldMargin: {
        marginLeft: "25px",
    }
};

const UserCreateForm = ({onNameChange, onSurnameChange, name, surname}) => {
    return (
        <div>
            <TextField
                floatingLabelText="Name"
                underlineShow={false}
                value={name}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onNameChange(event, value)}/>
            <TextField
                style={style.fieldMargin}
                floatingLabelText="Surname"
                underlineShow={false}
                value={surname}
                floatingLabelShrinkStyle={style.floatingLabelColor}
                onChange={(event, value) => onSurnameChange(event, value)}/>
            <FlatButton
                style={style.fieldMargin}
                label="CREATE USER"
                secondary={true}
                onClick={() => Service.create({
                    name: name,
                    surname: surname
                })}/>
        </div>
    )
};

UserCreateForm.defaultProps = {
    name: "",
    surname: ""
};

export default UserCreateForm;