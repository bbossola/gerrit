// Copyright (C) 2016 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
(function() {
  'use strict';

  Polymer({
    is: 'gr-account-link',

    properties: {
      account: Object,
      avatarImageSize: {
        type: Number,
        value: 32,
      },
    },

    behaviors: [
      Gerrit.BaseUrlBehavior,
    ],

    _computeOwnerLink(account) {
      if (!account) { return; }
      return Gerrit.Nav.getUrlForOwner(
          account.email || account.username || account._account_id);
    },

    _computeShowEmail(account) {
      return !!(account && !account.name);
    },
  });
})();
