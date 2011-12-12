/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.protocolPB;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.Options.Rename;
import org.apache.hadoop.hdfs.protocol.ClientProtocol;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AbandonBlockRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AbandonBlockResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AddBlockRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AddBlockResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AppendRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.AppendResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CancelDelegationTokenRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CancelDelegationTokenResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CompleteRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CompleteResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ConcatRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ConcatResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CreateRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CreateResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CreateSymlinkRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.CreateSymlinkResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.DeleteRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.DeleteResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.DistributedUpgradeProgressRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.DistributedUpgradeProgressResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.FinalizeUpgradeRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.FinalizeUpgradeResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.FsyncRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.FsyncResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetAdditionalDatanodeRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetAdditionalDatanodeResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetBlockLocationsRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetBlockLocationsResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetContentSummaryRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetContentSummaryResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetDatanodeReportRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetDatanodeReportResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetDelegationTokenRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetDelegationTokenResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFileInfoRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFileInfoResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFileLinkInfoRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFileLinkInfoResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFsStatsResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetFsStatusRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetLinkTargetRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetLinkTargetResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetListingRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetListingResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetPreferredBlockSizeRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetPreferredBlockSizeResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetServerDefaultsRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.GetServerDefaultsResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ListCorruptFileBlocksRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ListCorruptFileBlocksResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.MetaSaveRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.MetaSaveResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.MkdirsRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.MkdirsResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RecoverLeaseRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RecoverLeaseResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RefreshNodesRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RefreshNodesResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.Rename2RequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.Rename2ResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenameRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenameResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenewDelegationTokenRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenewDelegationTokenResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenewLeaseRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RenewLeaseResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ReportBadBlocksRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.ReportBadBlocksResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RestoreFailedStorageRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.RestoreFailedStorageResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SaveNamespaceRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SaveNamespaceResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetBalancerBandwidthRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetBalancerBandwidthResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetOwnerRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetOwnerResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetPermissionRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetPermissionResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetQuotaRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetQuotaResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetReplicationRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetReplicationResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetSafeModeRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetSafeModeResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetTimesRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.SetTimesResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.UpdateBlockForPipelineRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.UpdateBlockForPipelineResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.UpdatePipelineRequestProto;
import org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos.UpdatePipelineResponseProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.BlockTokenIdentifierProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.ContentSummaryProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.CorruptFileBlocksProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.DatanodeIDProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.DatanodeInfoProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.DirectoryListingProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.HdfsFileStatusProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.LocatedBlockProto;
import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.UpgradeStatusReportProto;
import org.apache.hadoop.hdfs.protocolR23Compatible.ProtocolSignatureWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;

/**
 * This class is used on the server side. Calls come across the wire for the
 * for protocol {@link ClientNamenodeProtocolPB}.
 * This class translates the PB data types
 * to the native data types used inside the NN as specified in the generic
 * ClientProtocol.
 */
@InterfaceAudience.Private
@InterfaceStability.Stable
public class ClientNamenodeProtocolServerSideTranslatorPB implements
    ClientNamenodeProtocolPB {
  final private ClientProtocol server;

  /**
   * Constructor
   * 
   * @param server - the NN server
   * @throws IOException
   */
  public ClientNamenodeProtocolServerSideTranslatorPB(ClientProtocol server)
      throws IOException {
    this.server = server;
  }

  /**
   * The client side will redirect getProtocolSignature to
   * getProtocolSignature2.
   * 
   * However the RPC layer below on the Server side will call getProtocolVersion
   * and possibly in the future getProtocolSignature. Hence we still implement
   * it even though the end client's call will never reach here.
   */
  @Override
  public ProtocolSignature getProtocolSignature(String protocol,
      long clientVersion, int clientMethodsHash) throws IOException {
    /**
     * Don't forward this to the server. The protocol version and signature is
     * that of {@link ClientNamenodeProtocol}
     * 
     */
    if (!protocol.equals(RPC.getProtocolName(
        ClientNamenodeProtocolPB.class))) {
      throw new IOException("Namenode Serverside implements " +
          RPC.getProtocolName(ClientNamenodeProtocolPB.class) +
          ". The following requested protocol is unknown: " + protocol);
    }

    return ProtocolSignature.getProtocolSignature(clientMethodsHash,
        RPC.getProtocolVersion(ClientNamenodeProtocolPB.class),
        ClientNamenodeProtocolPB.class);
  }

  @Override
  public ProtocolSignatureWritable 
          getProtocolSignature2(
      String protocol, long clientVersion, int clientMethodsHash)
      throws IOException {
    /**
     * Don't forward this to the server. The protocol version and signature is
     * that of {@link ClientNamenodeProtocol}
     * 
     */
    return ProtocolSignatureWritable.convert(
        this.getProtocolSignature(protocol, clientVersion, clientMethodsHash));
  }

  @Override
  public long getProtocolVersion(String protocol, long clientVersion)
      throws IOException {
    return RPC.getProtocolVersion(InterDatanodeProtocolPB.class);
  }

  @Override
  public GetBlockLocationsResponseProto getBlockLocations(
      RpcController controller, GetBlockLocationsRequestProto req)
      throws ServiceException {
    try {
      return GetBlockLocationsResponseProto
          .newBuilder()
          .setLocations(
              PBHelper.convert(server.getBlockLocations(req.getSrc(),
                  req.getOffset(), req.getLength()))).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetServerDefaultsResponseProto getServerDefaults(
      RpcController controller, GetServerDefaultsRequestProto req)
      throws ServiceException {
    try {
      return GetServerDefaultsResponseProto.newBuilder()
          .setServerDefaults(PBHelper.convert(server.getServerDefaults()))
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public CreateResponseProto create(RpcController controller,
      CreateRequestProto req) throws ServiceException {
    try {
      server.create(req.getSrc(), PBHelper.convert(req.getMasked()),
          req.getClientName(), PBHelper.convert(req.getCreateFlag()),
          req.getCreateParent(), (short) req.getReplication(),
          req.getBlockSize());
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return CreateResponseProto.newBuilder().build();

  }
  
  @Override
  public AppendResponseProto append(RpcController controller,
      AppendRequestProto req) throws ServiceException {
    try {
      return AppendResponseProto
          .newBuilder()
          .setBlock(
              PBHelper.convert(server.append(req.getSrc(), req.getClientName())))
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public SetReplicationResponseProto setReplication(RpcController controller,
      SetReplicationRequestProto req) throws ServiceException {
    try {
      return SetReplicationResponseProto
          .newBuilder()
          .setResult(
              server.setReplication(req.getSrc(), (short) req.getReplication()))
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }


  static final SetPermissionResponseProto SET_PERM_RESPONSE = 
      SetPermissionResponseProto.newBuilder().build();

  @Override
  public SetPermissionResponseProto setPermission(RpcController controller,
      SetPermissionRequestProto req) throws ServiceException {
    try {
      server.setPermission(req.getSrc(), PBHelper.convert(req.getPermission()));
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return SET_PERM_RESPONSE;
  }

  static final SetOwnerResponseProto SET_OWNER_RESPONSE = 
      SetOwnerResponseProto.newBuilder().build();

  @Override
  public SetOwnerResponseProto setOwner(RpcController controller,
      SetOwnerRequestProto req) throws ServiceException {
    try {
      server.setOwner(req.getSrc(), req.getUsername(), req.getGroupname());
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return SET_OWNER_RESPONSE;
  }

  static final AbandonBlockResponseProto ABD_BLOCK_RESPONSE = 
      AbandonBlockResponseProto.newBuilder().build();

  @Override
  public AbandonBlockResponseProto abandonBlock(RpcController controller,
      AbandonBlockRequestProto req) throws ServiceException {
    try {
      server.abandonBlock(PBHelper.convert(req.getB()), req.getSrc(),
          req.getHolder());
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return ABD_BLOCK_RESPONSE;
  }

  @Override
  public AddBlockResponseProto addBlock(RpcController controller,
      AddBlockRequestProto req) throws ServiceException {
    try {
      return AddBlockResponseProto.newBuilder().setBlock(
          PBHelper.convert(
          server.addBlock(req.getSrc(), req.getClientName(), 
                PBHelper.convert(req.getPrevious()), 
                PBHelper.convert(
                  (DatanodeInfoProto[]) req.getExcludeNodesList().toArray()))))
           .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetAdditionalDatanodeResponseProto getAdditionalDatanode(
      RpcController controller, GetAdditionalDatanodeRequestProto req)
      throws ServiceException {
    try {
      return GetAdditionalDatanodeResponseProto.newBuilder().setBlock(
          PBHelper.convert(
              server.getAdditionalDatanode(req.getSrc(),
                  PBHelper.convert(req.getBlk()), 
                  PBHelper.convert((DatanodeInfoProto[]) req.getExistingsList()
                      .toArray()), PBHelper
                  .convert((DatanodeInfoProto[]) req.getExcludesList()
                      .toArray()), req.getNumAdditionalNodes(), req
                  .getClientName())))
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  @Override
  public CompleteResponseProto complete(RpcController controller,
      CompleteRequestProto req) throws ServiceException {
    try {
      return CompleteResponseProto.newBuilder().setResult(
                server.complete(req.getSrc(), req.getClientName(),
                PBHelper.convert(req.getLast())))
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  static final ReportBadBlocksResponseProto VOID_REP_BAD_BLOCK_RESPONSE = 
      ReportBadBlocksResponseProto.newBuilder().build();
  
  @Override
  public ReportBadBlocksResponseProto reportBadBlocks(RpcController controller,
      ReportBadBlocksRequestProto req) throws ServiceException {
    try {
      server.reportBadBlocks(PBHelper.convertLocatedBlock(
          (LocatedBlockProto[]) req.getBlocksList().toArray()));
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return VOID_REP_BAD_BLOCK_RESPONSE;
  }

  static final ConcatResponseProto VOID_CONCAT_RESPONSE = 
      ConcatResponseProto.newBuilder().build();
  
  @Override
  public ConcatResponseProto concat(RpcController controller,
      ConcatRequestProto req) throws ServiceException {
    try {
      server.concat(req.getTrg(), (String[])req.getSrcsList().toArray());
    } catch (IOException e) {
      throw new ServiceException(e);
    }
    return VOID_CONCAT_RESPONSE;
  }

  @Override
  public RenameResponseProto rename(RpcController controller,
      RenameRequestProto req) throws ServiceException {
    try {
      boolean result = server.rename(req.getSrc(), req.getDst());
      return RenameResponseProto.newBuilder().setResult(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final Rename2ResponseProto VOID_RENAME2_RESPONSE = 
      Rename2ResponseProto.newBuilder().build();
  
  @Override
  public Rename2ResponseProto rename2(RpcController controller,
      Rename2RequestProto req) throws ServiceException {

    try {
      server.rename2(req.getSrc(), req.getDst(), 
          req.getOverwriteDest() ? Rename.OVERWRITE : Rename.NONE);
    } catch (IOException e) {
      throw new ServiceException(e);
    }   
    return VOID_RENAME2_RESPONSE;
  }

  @Override
  public DeleteResponseProto delete(RpcController controller,
    DeleteRequestProto req) throws ServiceException {
    try {
      boolean result =  server.delete(req.getSrc(), req.getRecursive());
      return DeleteResponseProto.newBuilder().setResult(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public MkdirsResponseProto mkdirs(RpcController controller,
      MkdirsRequestProto req) throws ServiceException {
    try {
      boolean result = server.mkdirs(req.getSrc(),
          PBHelper.convert(req.getMasked()), req.getCreateParent());
      return MkdirsResponseProto.newBuilder().setResult(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetListingResponseProto getListing(RpcController controller,
      GetListingRequestProto req) throws ServiceException {
    try {
      DirectoryListingProto result = PBHelper.convert(server.getListing(
          req.getSrc(), req.getStartAfter().toByteArray(),
          req.getNeedLocation()));
      return GetListingResponseProto.newBuilder().setDirList(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  static final RenewLeaseResponseProto VOID_RENEWLEASE_RESPONSE = 
      RenewLeaseResponseProto.newBuilder().build();
  
  @Override
  public RenewLeaseResponseProto renewLease(RpcController controller,
      RenewLeaseRequestProto req) throws ServiceException {
    try {
      server.renewLease(req.getClientName());
      return VOID_RENEWLEASE_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public RecoverLeaseResponseProto recoverLease(RpcController controller,
      RecoverLeaseRequestProto req) throws ServiceException {
    try {
      boolean result = server.recoverLease(req.getSrc(), req.getClientName());
      return RecoverLeaseResponseProto.newBuilder().setResult(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  @Override
  public GetFsStatsResponseProto getFsStats(RpcController controller,
      GetFsStatusRequestProto req) throws ServiceException {
    try {
      return PBHelper.convert(server.getStats());
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetDatanodeReportResponseProto getDatanodeReport(
      RpcController controller, GetDatanodeReportRequestProto req)
      throws ServiceException {
    try {
      DatanodeInfoProto[] result = PBHelper.convert(server
          .getDatanodeReport(PBHelper.convert(req.getType())));
      return GetDatanodeReportResponseProto.newBuilder()
          .addAllDi(Arrays.asList(result)).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetPreferredBlockSizeResponseProto getPreferredBlockSize(
      RpcController controller, GetPreferredBlockSizeRequestProto req)
      throws ServiceException {
    try {
      long result = server.getPreferredBlockSize(req.getFilename());
      return GetPreferredBlockSizeResponseProto.newBuilder().setBsize(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public SetSafeModeResponseProto setSafeMode(RpcController controller,
      SetSafeModeRequestProto req) throws ServiceException {
    try {
      boolean result = server.setSafeMode(PBHelper.convert(req.getAction()));
      return SetSafeModeResponseProto.newBuilder().setResult(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  static final SaveNamespaceResponseProto VOID_SAVENAMESPACE_RESPONSE = 
      SaveNamespaceResponseProto.newBuilder().build();

  @Override
  public SaveNamespaceResponseProto saveNamespace(RpcController controller,
      SaveNamespaceRequestProto req) throws ServiceException {
    try {
      server.saveNamespace();
      return VOID_SAVENAMESPACE_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }

  }

  @Override
  public RestoreFailedStorageResponseProto restoreFailedStorage(
      RpcController controller, RestoreFailedStorageRequestProto req)
      throws ServiceException {
    try {
      boolean result = server.restoreFailedStorage(req.getArg());
      return RestoreFailedStorageResponseProto.newBuilder().setResult(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final RefreshNodesResponseProto VOID_REFRESHNODES_RESPONSE = 
      RefreshNodesResponseProto.newBuilder().build();

  @Override
  public RefreshNodesResponseProto refreshNodes(RpcController controller,
      RefreshNodesRequestProto req) throws ServiceException {
    try {
      server.refreshNodes();
      return VOID_REFRESHNODES_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }

  }

  static final FinalizeUpgradeResponseProto VOID_FINALIZEUPGRADE_RESPONSE = 
      FinalizeUpgradeResponseProto.newBuilder().build();

  @Override
  public FinalizeUpgradeResponseProto finalizeUpgrade(RpcController controller,
      FinalizeUpgradeRequestProto req) throws ServiceException {
    try {
      server.finalizeUpgrade();
      return VOID_FINALIZEUPGRADE_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public DistributedUpgradeProgressResponseProto distributedUpgradeProgress(
      RpcController controller, DistributedUpgradeProgressRequestProto req)
      throws ServiceException {
    try {
      UpgradeStatusReportProto result = PBHelper.convert(server
          .distributedUpgradeProgress(PBHelper.convert(req.getAction())));
      return DistributedUpgradeProgressResponseProto.newBuilder()
          .setReport(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public ListCorruptFileBlocksResponseProto listCorruptFileBlocks(
      RpcController controller, ListCorruptFileBlocksRequestProto req)
      throws ServiceException {
    try {
      CorruptFileBlocksProto result = PBHelper.convert(server
          .listCorruptFileBlocks(req.getPath(), req.getCookie()));
      return ListCorruptFileBlocksResponseProto.newBuilder().setCorrupt(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final MetaSaveResponseProto VOID_METASAVE_RESPONSE = 
      MetaSaveResponseProto.newBuilder().build();
  
  @Override
  public MetaSaveResponseProto metaSave(RpcController controller,
      MetaSaveRequestProto req) throws ServiceException {
    try {
      server.metaSave(req.getFilename());
      return VOID_METASAVE_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }

  }

  @Override
  public GetFileInfoResponseProto getFileInfo(RpcController controller,
      GetFileInfoRequestProto req) throws ServiceException {
    try {
      HdfsFileStatusProto result = 
          PBHelper.convert(server.getFileInfo(req.getSrc()));
      return GetFileInfoResponseProto.newBuilder().setFs(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetFileLinkInfoResponseProto getFileLinkInfo(RpcController controller,
      GetFileLinkInfoRequestProto req) throws ServiceException {
    try {
      HdfsFileStatusProto result = 
          PBHelper.convert(server.getFileLinkInfo(req.getSrc()));
      return GetFileLinkInfoResponseProto.newBuilder().setFs(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetContentSummaryResponseProto getContentSummary(
      RpcController controller, GetContentSummaryRequestProto req)
      throws ServiceException {
    try {
      ContentSummaryProto result = 
          PBHelper.convert(server.getContentSummary(req.getPath()));
      return 
        GetContentSummaryResponseProto.newBuilder().setSummary(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  static final SetQuotaResponseProto VOID_SETQUOTA_RESPONSE = 
      SetQuotaResponseProto.newBuilder().build();
  
  @Override
  public SetQuotaResponseProto setQuota(RpcController controller,
      SetQuotaRequestProto req) throws ServiceException {
    try {
      server.setQuota(req.getPath(), req.getNamespaceQuota(),
          req.getDiskspaceQuota());
      return VOID_SETQUOTA_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
  
  static final FsyncResponseProto VOID_FSYNC_RESPONSE = 
      FsyncResponseProto.newBuilder().build();

  @Override
  public FsyncResponseProto fsync(RpcController controller,
      FsyncRequestProto req) throws ServiceException {
    try {
      server.fsync(req.getSrc(), req.getClient());
      return VOID_FSYNC_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final SetTimesResponseProto VOID_SETTIMES_RESPONSE = 
      SetTimesResponseProto.newBuilder().build();

  @Override
  public SetTimesResponseProto setTimes(RpcController controller,
      SetTimesRequestProto req) throws ServiceException {
    try {
      server.setTimes(req.getSrc(), req.getMtime(), req.getAtime());
      return VOID_SETTIMES_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final CreateSymlinkResponseProto VOID_CREATESYMLINK_RESPONSE = 
      CreateSymlinkResponseProto.newBuilder().build();

  @Override
  public CreateSymlinkResponseProto createSymlink(RpcController controller,
      CreateSymlinkRequestProto req) throws ServiceException {
    try {
      server.createSymlink(req.getTarget(), req.getLink(),
          PBHelper.convert(req.getDirPerm()), req.getCreateParent());
      return VOID_CREATESYMLINK_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetLinkTargetResponseProto getLinkTarget(RpcController controller,
      GetLinkTargetRequestProto req) throws ServiceException {
    try {
      String result = server.getLinkTarget(req.getPath());
      return GetLinkTargetResponseProto.newBuilder().setTargetPath(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public UpdateBlockForPipelineResponseProto updateBlockForPipeline(
      RpcController controller, UpdateBlockForPipelineRequestProto req)
      throws ServiceException {
    try {
      LocatedBlockProto result = PBHelper.convert(server
          .updateBlockForPipeline(PBHelper.convert(req.getBlock()),
              req.getClientName()));
      return UpdateBlockForPipelineResponseProto.newBuilder().setBlock(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final UpdatePipelineResponseProto VOID_UPDATEPIPELINE_RESPONSE = 
      UpdatePipelineResponseProto.newBuilder().build();

  @Override
  public UpdatePipelineResponseProto updatePipeline(RpcController controller,
      UpdatePipelineRequestProto req) throws ServiceException {
    try {
      server
          .updatePipeline(req.getClientName(), PBHelper.convert(req
              .getOldBlock()), PBHelper.convert(req.getNewBlock()), PBHelper
              .convert((DatanodeIDProto[]) req.getNewNodesList().toArray()));
      return VOID_UPDATEPIPELINE_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public GetDelegationTokenResponseProto getDelegationToken(
      RpcController controller, GetDelegationTokenRequestProto req)
      throws ServiceException {
    try {
      BlockTokenIdentifierProto result = PBHelper.convert(server
          .getDelegationToken(new Text(req.getRenewer())));
      return GetDelegationTokenResponseProto.newBuilder().setToken(result)
          .build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  @Override
  public RenewDelegationTokenResponseProto renewDelegationToken(
      RpcController controller, RenewDelegationTokenRequestProto req)
      throws ServiceException {
    try {
      long result = server.renewDelegationToken(PBHelper
          .convertDelegationToken(req.getToken()));
      return RenewDelegationTokenResponseProto.newBuilder()
          .setNewExireTime(result).build();
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final CancelDelegationTokenResponseProto 
      VOID_CANCELDELEGATIONTOKEN_RESPONSE = 
      CancelDelegationTokenResponseProto.newBuilder().build();
  
  @Override
  public CancelDelegationTokenResponseProto cancelDelegationToken(
      RpcController controller, CancelDelegationTokenRequestProto req)
      throws ServiceException {
    try {
      server.cancelDelegationToken(PBHelper.convertDelegationToken(req
          .getToken()));
      return VOID_CANCELDELEGATIONTOKEN_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }

  static final SetBalancerBandwidthResponseProto 
    VOID_SETBALANCERBANDWIDTH_RESPONSE = 
      SetBalancerBandwidthResponseProto.newBuilder().build();

  @Override
  public SetBalancerBandwidthResponseProto setBalancerBandwidth(
      RpcController controller, SetBalancerBandwidthRequestProto req)
      throws ServiceException {
    try {
      server.setBalancerBandwidth(req.getBandwidth());
      return VOID_SETBALANCERBANDWIDTH_RESPONSE;
    } catch (IOException e) {
      throw new ServiceException(e);
    }
  }
}
