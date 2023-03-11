import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from '@mui/material/Card';
import CardHeader from "@material-ui/core/CardHeader";
import Avatar from "@material-ui/core/Avatar";
import IconButton from "@material-ui/core/IconButton";
import CancelIcon from '@mui/icons-material/Cancel';
export default function ImgMediaCard({count}) {
  return (
    <Card>
      <CardHeader
        avatar={
          <CancelIcon color="error" fontSize="large"/>
        }
        action={
          <IconButton aria-label="settings">
            {count}
          </IconButton>
        }
        title="Rejected"
        subheader="The rejected reqeust count is"
      />
    </Card>
  );
}
