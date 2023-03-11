import React from "react";
import Card from '@mui/material/Card';
import CardHeader from "@material-ui/core/CardHeader";
import IconButton from "@material-ui/core/IconButton";
import PendingIcon from '@mui/icons-material/Pending';
export default function ImgMediaCard({count}) {
  return (
    <Card>
      <CardHeader
        avatar={
          <PendingIcon color="warning" fontSize="large" />
        }
        action={
          <IconButton aria-label="settings">
            {count}
          </IconButton>
        }
        title="Pending"
        subheader="The pending request count is"
      />
    </Card>
  );
}
