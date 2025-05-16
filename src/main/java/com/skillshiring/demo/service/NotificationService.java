package com.skillshiring.demo.service;

const Notification = require('../models/Notification');
const { getIo } = require('../utils/socket');

const createNotification = async ({ recipient, sender, type, post, content }) => {
        try {
        const notification = new Notification({
    recipient,
            sender,
            type,
            post,
            content,
});
await notification.save();

// Emit real-time notification
    const io = getIo();
    io.to(recipient.toString()).emit('newNotification', notification);
  } catch (error) {
        console.error('Error creating notification:', error);
  }
          };

module.exports = { createNotification };
