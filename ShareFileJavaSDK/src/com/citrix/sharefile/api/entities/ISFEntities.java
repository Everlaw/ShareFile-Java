// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2015 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.citrix.sharefile.api.entities;

import com.citrix.sharefile.api.interfaces.ISFApiClient;

import java.lang.reflect.InvocationTargetException;

public interface ISFEntities {
    public static abstract class Implementation extends SFODataEntityBase implements ISFEntities
    {
        private static final String TAG = "ISFEntities";

        protected Implementation()
        {
    
        }

        public SFODataEntityBase getEntity(Class className)
        {
            try
            {
                if(this instanceof ISFApiClient)
                {
                    return (SFODataEntityBase) className.getConstructor(ISFApiClient.class).newInstance(this);
                }
                else
                {
                    return (SFODataEntityBase) className.newInstance();
                }
            }
            catch (InstantiationException e)
            {
                throw new RuntimeException(e);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException(e);
            }
            catch (NoSuchMethodException e)
            {
                throw new RuntimeException(e);
            }
            catch (InvocationTargetException e)
            {
                throw new RuntimeException(e);
            }
        }

        @Override
        public SFConnectorGroupsEntity connectorGroups()
        {
            return (SFConnectorGroupsEntity) getEntity(SFConnectorGroupsEntity.class);
        }
        @Override
        public SFFolderTemplatesEntity folderTemplates() {
            return (SFFolderTemplatesEntity) getEntity(SFFolderTemplatesEntity.class);
        }
        @Override
        public SFAccessControlsEntity accessControls() {
            return (SFAccessControlsEntity) getEntity(SFAccessControlsEntity.class);
        }
        @Override
        public SFAccountsEntity accounts() {
            return (SFAccountsEntity) getEntity(SFAccountsEntity.class);
        }
        @Override
        public SFAsyncOperationsEntity asyncOperations() {
            return (SFAsyncOperationsEntity) getEntity(SFAsyncOperationsEntity.class);
        }
        @Override
        public SFCapabilitiesEntity capabilities() {
            return (SFCapabilitiesEntity) getEntity(SFCapabilitiesEntity.class);
        }
        @Override
        public SFFavoriteFoldersEntity favoriteFolders() {
            return (SFFavoriteFoldersEntity) getEntity(SFFavoriteFoldersEntity.class);
        }
        @Override
        public SFGroupsEntity groups() {
            return (SFGroupsEntity) getEntity(SFGroupsEntity.class);
        }
        @Override
        public SFItemsEntity items() {
            return (SFItemsEntity) getEntity(SFItemsEntity.class);
        }
        @Override
        public SFMetadataEntity metadata() {
            return (SFMetadataEntity) getEntity(SFMetadataEntity.class);
        }
        @Override
        public SFSessionsEntity sessions() {
            return (SFSessionsEntity) getEntity(SFSessionsEntity.class);
        }
        @Override
        public SFSharesEntity shares() {
            return (SFSharesEntity) getEntity(SFSharesEntity.class);
        }
        @Override
        public SFStorageCentersEntity storageCenters() {
            return (SFStorageCentersEntity) getEntity(SFStorageCentersEntity.class);
        }
        @Override
        public SFUsersEntity users() {
            return (SFUsersEntity) getEntity(SFUsersEntity.class);
        }
        @Override
        public SFZonesEntity zones() {
            return (SFZonesEntity) getEntity(SFZonesEntity.class);
        }

        @Override
        public SFConfigsEntity configs()
        {
            return (SFConfigsEntity)getEntity(SFConfigsEntity.class);
        }

        @Override
        public SFDevicesEntity devices()
        {
            return  (SFDevicesEntity)getEntity(SFDevicesEntity.class);
        }

        @Override
        public SFFileLockEntity fileLock()
        {
            return (SFFileLockEntity)getEntity(SFFileLockEntity.class);
        }
    }

    SFConnectorGroupsEntity connectorGroups();
    SFODataEntityBase folderTemplates();
    SFAccessControlsEntity accessControls();
    SFAccountsEntity accounts();
    SFAsyncOperationsEntity asyncOperations();
    SFCapabilitiesEntity capabilities();
    SFFavoriteFoldersEntity favoriteFolders();
    SFGroupsEntity groups();
    SFItemsEntity items();
    SFMetadataEntity metadata();
    SFSessionsEntity sessions();
    SFSharesEntity shares();
    SFStorageCentersEntity storageCenters();
    SFUsersEntity users();
    SFZonesEntity zones();
    SFConfigsEntity configs();
    SFDevicesEntity devices();
    SFFileLockEntity fileLock();
}